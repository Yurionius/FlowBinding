package reactivecircus.flowbinding.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.testing.TestLifecycleOwner
import androidx.test.filters.LargeTest
import org.amshove.kluent.shouldEqual
import org.junit.Test
import reactivecircus.flowbinding.lifecycle.fixtures.LifecycleFragment
import reactivecircus.flowbinding.testing.FlowRecorder
import reactivecircus.flowbinding.testing.launchTest
import reactivecircus.flowbinding.testing.recordWith

@LargeTest
class LifecycleEventFlowTest {

    @Test
    fun lifecycleEvents() {
        launchTest<LifecycleFragment> {
            val recorder = FlowRecorder<Lifecycle.Event>(testScope)
            val owner = TestLifecycleOwner(Lifecycle.State.INITIALIZED)
            owner.lifecycle.events().recordWith(recorder)

            owner.currentState = Lifecycle.State.CREATED
            recorder.takeValue() shouldEqual Lifecycle.Event.ON_CREATE
            recorder.assertNoMoreValues()

            owner.currentState = Lifecycle.State.STARTED
            recorder.takeValue() shouldEqual Lifecycle.Event.ON_START
            recorder.assertNoMoreValues()

            owner.currentState = Lifecycle.State.RESUMED
            recorder.takeValue() shouldEqual Lifecycle.Event.ON_RESUME
            recorder.assertNoMoreValues()

            cancelTestScope()

            owner.currentState = Lifecycle.State.DESTROYED
            recorder.assertNoMoreValues()
        }
    }
}
