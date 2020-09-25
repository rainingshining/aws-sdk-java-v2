package software.amazon.awssdk.services.query.waiters;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;
import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.annotations.SdkPublicApi;
import software.amazon.awssdk.core.waiters.WaiterOverrideConfiguration;
import software.amazon.awssdk.core.waiters.WaiterResponse;
import software.amazon.awssdk.services.query.QueryAsyncClient;
import software.amazon.awssdk.services.query.model.APostOperationRequest;
import software.amazon.awssdk.services.query.model.APostOperationResponse;
import software.amazon.awssdk.utils.SdkAutoCloseable;

/**
 * Waiter utility class that polls a resource until a desired state is reached or until it is determined that the
 * resource will never enter into the desired state. This can be created using the static {@link #builder()} method
 */
@Generated("software.amazon.awssdk:codegen")
@SdkPublicApi
public interface QueryAsyncWaiter extends SdkAutoCloseable {
    /**
     * Polls {@link QueryAsyncClient#aPostOperation} API until the desired condition {@code PostOperationSuccess} is
     * met, or until it is determined that the resource will never enter into the desired state
     *
     * @param aPostOperationRequest
     *        the request to be used for polling
     * @return CompletableFuture of the WaiterResponse containing either a response or an exception that has matched with the waiter success
     *         condition
     */
    default CompletableFuture<WaiterResponse<APostOperationResponse>> waitUntilPostOperationSuccess(
        APostOperationRequest aPostOperationRequest) {
        throw new UnsupportedOperationException();
    }

    /**
     * Polls {@link QueryAsyncClient#aPostOperation} API until the desired condition {@code PostOperationSuccess} is
     * met, or until it is determined that the resource will never enter into the desired state.
     * <p>
     * This is a convenience method to create an instance of the request builder without the need to create one manually
     * using {@link APostOperationRequest.builder()}
     *
     * @param aPostOperationRequest
     *        the request to be used for polling
     * @return CompletableFuture of the WaiterResponse containing either a response or an exception that has matched with the waiter success
     *         condition
     */
    default CompletableFuture<WaiterResponse<APostOperationResponse>> waitUntilPostOperationSuccess(
        Consumer<APostOperationRequest.Builder> aPostOperationRequest) {
        return waitUntilPostOperationSuccess(APostOperationRequest.builder().applyMutation(aPostOperationRequest).build());
    }

    /**
     * Create a builder that can be used to configure and create a {@link QueryAsyncWaiter}.
     *
     * @return a builder
     */
    static Builder builder() {
        return DefaultQueryAsyncWaiter.builder();
    }

    /**
     * Create an instance of {@link QueryAsyncWaiter} with the default configuration
     *
     * @return an instance of {@link QueryAsyncWaiter}
     */
    static QueryAsyncWaiter create() {
        return DefaultQueryAsyncWaiter.builder().build();
    }

    interface Builder {
        /**
         * Sets a custom {@link ScheduledExecutorService} that will be used to schedule async polling attempts
         * <p>
         * This executorService must be closed by the caller when it is ready to be disposed. The SDK will not close the
         * executorService when the waiter is closed
         *
         * @param executorService
         *        the executorService to set
         * @return a reference to this object so that method calls can be chained together.
         */
        Builder scheduledExecutorService(ScheduledExecutorService executorService);

        /**
         * Defines overrides to the default SDK waiter configuration that should be used for waiters created from this
         * builder
         *
         * @param overrideConfiguration
         *        the override configuration to set
         * @return a reference to this object so that method calls can be chained together.
         */
        Builder overrideConfiguration(WaiterOverrideConfiguration overrideConfiguration);

        /**
         * This is a convenient method to pass the override configuration without the need to create an instance
         * manually via {@link WaiterOverrideConfiguration.builder()}
         *
         * @param overrideConfiguration
         *        The consumer that will configure the overrideConfiguration
         * @return a reference to this object so that method calls can be chained together.
         * @see #overrideConfiguration(WaiterOverrideConfiguration)
         */
        default Builder overrideConfiguration(Consumer<WaiterOverrideConfiguration.Builder> overrideConfiguration) {
            WaiterOverrideConfiguration.Builder builder = WaiterOverrideConfiguration.builder();
            overrideConfiguration.accept(builder);
            return overrideConfiguration(builder.build());
        }

        /**
         * Sets a custom {@link QueryAsyncClient} that will be used to pool the resource
         * <p>
         * This SDK client must be closed by the caller when it is ready to be disposed. The SDK will not close the
         * client when the waiter is closed
         *
         * @param client
         *        the client to send the request
         * @return a reference to this object so that method calls can be chained together.
         */
        Builder client(QueryAsyncClient client);

        /**
         * Builds an instance of {@link QueryAsyncWaiter} based on the configurations supplied to this builder
         *
         * @return An initialized {@link QueryAsyncWaiter}
         */
        QueryAsyncWaiter build();
    }
}