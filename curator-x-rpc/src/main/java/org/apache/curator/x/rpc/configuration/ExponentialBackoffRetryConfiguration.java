package org.apache.curator.x.rpc.configuration;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.airlift.units.Duration;
import org.apache.curator.RetryPolicy;
import org.apache.curator.retry.ExponentialBackoffRetry;
import java.util.concurrent.TimeUnit;

@JsonTypeName("exponential-backoff")
public class ExponentialBackoffRetryConfiguration extends RetryPolicyConfiguration
{
    private Duration baseSleepTime = new Duration(100, TimeUnit.MILLISECONDS);
    private int maxRetries = 3;

    @Override
    public RetryPolicy build()
    {
        return new ExponentialBackoffRetry((int)baseSleepTime.toMillis(), maxRetries);
    }

    public Duration getBaseSleepTime()
    {
        return baseSleepTime;
    }

    public void setBaseSleepTime(Duration baseSleepTime)
    {
        this.baseSleepTime = baseSleepTime;
    }

    public int getMaxRetries()
    {
        return maxRetries;
    }

    public void setMaxRetries(int maxRetries)
    {
        this.maxRetries = maxRetries;
    }
}
