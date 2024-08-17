package me.corecraft.paper.scheduler;

import com.ryderbelserion.vital.paper.util.scheduler.FoliaRunnable;
import me.corecraft.paper.CoreCraft;
import me.corecraft.common.interfaces.Scheduler;
import java.util.function.Consumer;

public class PaperScheduler implements Scheduler {

    private final CoreCraft plugin = CoreCraft.getPlugin();

    /**
     * {@inheritDoc}
     *
     * @param task {@inheritDoc}
     * @param delay {@inheritDoc}
     */
    @Override
    public void runDelayedTask(final Consumer<Scheduler> task, final long delay) {
        new FoliaRunnable(this.plugin.getServer().getGlobalRegionScheduler()) {
            @Override
            public void run() {
                task.accept(PaperScheduler.this);
            }
        }.runDelayed(this.plugin, delay);
    }

    /**
     * {@inheritDoc}
     *
     * @param task {@inheritDoc}
     * @param delay {@inheritDoc}
     * @param interval {@inheritDoc}
     */
    @Override
    public void runRepeatingTask(final Consumer<Scheduler> task, final long delay, final long interval) {
        new FoliaRunnable(this.plugin.getServer().getGlobalRegionScheduler()) {
            @Override
            public void run() {
                task.accept(PaperScheduler.this);
            }
        }.runAtFixedRate(this.plugin, delay, interval);
    }

    /**
     * {@inheritDoc}
     *
     * @param task {@inheritDoc}
     * @param interval {@inheritDoc}
     */
    @Override
    public void runRepeatingTask(final Consumer<Scheduler> task, final long interval) {
        new FoliaRunnable(this.plugin.getServer().getGlobalRegionScheduler()) {
            @Override
            public void run() {
                task.accept(PaperScheduler.this);
            }
        }.runAtFixedRate(this.plugin, 0L, interval);
    }

    /**
     * {@inheritDoc}
     *
     * @param task {@inheritDoc}
     * @param delay {@inheritDoc}
     * @param interval {@inheritDoc}
     */
    @Override
    public void runRepeatingAsyncTask(final Consumer<Scheduler> task, final long delay, final long interval) {
        new FoliaRunnable(this.plugin.getServer().getAsyncScheduler(), null) {
            @Override
            public void run() {
                task.accept(PaperScheduler.this);
            }
        }.runAtFixedRate(this.plugin, delay, interval);
    }

    /**
     * {@inheritDoc}
     *
     * @param task {@inheritDoc}
     * @param delay {@inheritDoc}
     */
    @Override
    public void runDelayedAsyncTask(final Consumer<Scheduler> task, final long delay) {
        new FoliaRunnable(this.plugin.getServer().getAsyncScheduler(), null) {
            @Override
            public void run() {
                task.accept(PaperScheduler.this);
            }
        }.runDelayed(this.plugin, delay);
    }
}