package me.corecraft.velocity.scheduler;

import me.corecraft.common.interfaces.Scheduler;
import me.corecraft.velocity.CoreCraft;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class VeloScheduler implements Scheduler {

    private final CoreCraft plugin = CoreCraft.getPlugin();

    /**
     * {@inheritDoc}
     *
     * @param task {@inheritDoc}
     * @param delay {@inheritDoc}
     */
    @Override
    public void runDelayedTask(final Consumer<Scheduler> task, final long delay) {
        this.plugin.getServer().getScheduler().buildTask(this.plugin, () -> task.accept(this)).delay(delay, TimeUnit.SECONDS).schedule();
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
        runRepeatingTask(task, interval);
    }

    /**
     * {@inheritDoc}
     *
     * @param task {@inheritDoc}
     * @param interval {@inheritDoc}
     */
    @Override
    public void runRepeatingTask(final Consumer<Scheduler> task, final long interval) {
        this.plugin.getServer().getScheduler().buildTask(this.plugin, () -> task.accept(this)).repeat(interval, TimeUnit.SECONDS).schedule();
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
        runRepeatingTask(task, delay, interval);
    }

    /**
     * {@inheritDoc}
     *
     * @param task {@inheritDoc}
     * @param delay {@inheritDoc}
     */
    @Override
    public void runDelayedAsyncTask(final Consumer<Scheduler> task, final long delay) {
        runDelayedTask(task, delay);
    }
}