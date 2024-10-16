package net.nathan.frights_and_foliage.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class FumkinEntity extends AnimalEntity {
    private static final TrackedData<Integer> ANTLER_STAGE;
    private int ticksUntilNextStage;

    public FumkinEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.25));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(3, new TemptGoal(this, 1.1, Ingredient.ofItems(Items.WHEAT), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ANTLER_STAGE, 2);
    }

    public static DefaultAttributeContainer.Builder createFumkinAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
    }

    @Override
    public void tickMovement() {
        super.tickMovement();

        if (this.ticksUntilNextStage > 0) {
            this.ticksUntilNextStage--;
            if (this.ticksUntilNextStage == 0) {
                progressAntlerGrowth();
            }
        }
    }

    public void setAntlerStage(int stage) {
        this.dataTracker.set(ANTLER_STAGE, stage);
    }

    public int getAntlerStage() {
        return this.dataTracker.get(ANTLER_STAGE);
    }

    private void scheduleNextStage() {
        Random random = new Random();
        this.ticksUntilNextStage = random.nextInt(6000) + 6000;
    }

    private void progressAntlerGrowth() {
        int currentStage = this.getAntlerStage();
        if (currentStage < 2) {
            this.setAntlerStage(currentStage + 1);
            if (currentStage + 1 < 2) {
                this.scheduleNextStage();
            }
        }
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isIn(ItemTags.AXES)) {
            if (this.getAntlerStage() == 2 && !this.getWorld().isClient) {
                this.dropAntlers(SoundCategory.PLAYERS);
                this.emitGameEvent(GameEvent.SHEAR, player);
                itemStack.damage(1, player, (p) -> p.sendToolBreakStatus(hand));
                return ActionResult.SUCCESS;
            }
        }
        return super.interactMob(player, hand);
    }

    private void dropAntlers(SoundCategory soundCategory) {
        this.getWorld().playSoundFromEntity((PlayerEntity)null, this, SoundEvents.ITEM_AXE_STRIP, soundCategory, 1.0F, 1.0F);
        this.setAntlerStage(0);
        this.dropItem(Items.BONE);
        this.scheduleNextStage();
    }

    @Nullable
    @Override
    public FumkinEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    static {
        ANTLER_STAGE = DataTracker.registerData(FumkinEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }
}
