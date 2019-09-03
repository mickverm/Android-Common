package be.mickverm.common.extensions

import android.app.Activity
import android.view.View
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController

@RunWith(value = RobolectricTestRunner::class)
class ViewExtTest {

    private lateinit var activityController: ActivityController<Activity>
    private lateinit var activity: Activity

    private lateinit var visibleView: View
    private lateinit var invisibleView: View
    private lateinit var goneView: View
    private lateinit var visibilityViews: List<View>

    private lateinit var enabledView: View
    private lateinit var disabledView: View
    private lateinit var enabledViews: List<View>

    @Before
    fun setup() {
        activityController = Robolectric.buildActivity(Activity::class.java)
        activity = activityController.get()

        visibleView = View(activity)
        invisibleView = View(activity).apply { visibility = View.INVISIBLE }
        goneView = View(activity).apply { visibility = View.GONE }
        visibilityViews = listOf(
                visibleView,
                invisibleView,
                goneView
        )

        enabledView = View(activity)
        disabledView = View(activity).apply { isEnabled = false }
        enabledViews = listOf(
                enabledView,
                disabledView
        )
    }

    @Test
    fun view_ShouldBe_Gone_AfterHide() {
        visibleView.hide()
        assertEquals(View.GONE, visibleView.visibility)
        invisibleView.hide()
        assertEquals(View.GONE, invisibleView.visibility)
        goneView.hide()
        assertEquals(View.GONE, goneView.visibility)
    }

    @Test
    fun view_ShouldBe_Invisible_AfterHide() {
        visibleView.hide(false)
        assertEquals(View.INVISIBLE, visibleView.visibility)
        invisibleView.hide(false)
        assertEquals(View.INVISIBLE, invisibleView.visibility)
        goneView.hide(false)
        assertEquals(View.INVISIBLE, goneView.visibility)
    }

    @Test
    fun view_ShouldBe_Visible_AfterShow() {
        visibleView.show()
        assertEquals(View.VISIBLE, visibleView.visibility)
        invisibleView.show()
        assertEquals(View.VISIBLE, invisibleView.visibility)
        goneView.show()
        assertEquals(View.VISIBLE, goneView.visibility)
    }

    @Test
    fun view_ShouldBe_Visible_AfterVisible() {
        visibleView.visible()
        assertEquals(View.VISIBLE, visibleView.visibility)
        invisibleView.visible()
        assertEquals(View.VISIBLE, invisibleView.visibility)
        goneView.visible()
        assertEquals(View.VISIBLE, goneView.visibility)
    }

    @Test
    fun view_ShouldBe_Invisible_AfterVisible() {
        visibleView.visible(visible = false, gone = false)
        assertEquals(View.INVISIBLE, visibleView.visibility)
        invisibleView.visible(visible = false, gone = false)
        assertEquals(View.INVISIBLE, invisibleView.visibility)
        goneView.visible(visible = false, gone = false)
        assertEquals(View.INVISIBLE, goneView.visibility)
    }

    @Test
    fun view_ShouldBe_Gone_AfterVisible() {
        visibleView.visible(visible = false)
        assertEquals(View.GONE, visibleView.visibility)
        invisibleView.visible(visible = false, gone = true)
        assertEquals(View.GONE, invisibleView.visibility)
        goneView.visible(visible = false)
        assertEquals(View.GONE, goneView.visibility)
    }

    @Test
    fun view_ShouldReturn_True_IfVisible() {
        assertEquals(true, visibleView.isVisible())
        assertEquals(false, invisibleView.isVisible())
        assertEquals(false, goneView.isVisible())
    }

    @Test
    fun view_ShouldReturn_True_IfInvisible() {
        assertEquals(false, visibleView.isInvisible())
        assertEquals(true, invisibleView.isInvisible())
        assertEquals(false, goneView.isInvisible())
    }

    @Test
    fun view_ShouldReturn_True_IfGone() {
        assertEquals(false, visibleView.isGone())
        assertEquals(false, invisibleView.isGone())
        assertEquals(true, goneView.isGone())
    }

    @Test
    fun view_ShouldReturn_True_IfNotVisible() {
        assertEquals(false, visibleView.isNotVisible())
        assertEquals(true, invisibleView.isNotVisible())
        assertEquals(true, goneView.isNotVisible())
    }

    @Test
    fun views_ShouldBe_Gone_AfterHide() {
        visibilityViews.hide()
        assertEquals(View.GONE, visibleView.visibility)
        assertEquals(View.GONE, invisibleView.visibility)
        assertEquals(View.GONE, goneView.visibility)
    }

    @Test
    fun views_ShouldBe_Invisible_AfterHide() {
        visibilityViews.hide(false)
        assertEquals(View.INVISIBLE, visibleView.visibility)
        assertEquals(View.INVISIBLE, invisibleView.visibility)
        assertEquals(View.INVISIBLE, goneView.visibility)
    }

    @Test
    fun views_ShouldBe_Visible_AfterShow() {
        visibilityViews.show()
        assertEquals(View.VISIBLE, visibleView.visibility)
        assertEquals(View.VISIBLE, invisibleView.visibility)
        assertEquals(View.VISIBLE, goneView.visibility)
    }

    @Test
    fun views_ShouldBe_Visible_AfterVisible() {
        visibilityViews.visible()
        assertEquals(View.VISIBLE, visibleView.visibility)
        assertEquals(View.VISIBLE, invisibleView.visibility)
        assertEquals(View.VISIBLE, goneView.visibility)
    }

    @Test
    fun views_ShouldBe_Invisible_AfterVisible() {
        visibilityViews.visible(false, gone = false)
        assertEquals(View.INVISIBLE, visibleView.visibility)
        assertEquals(View.INVISIBLE, invisibleView.visibility)
        assertEquals(View.INVISIBLE, goneView.visibility)
    }

    @Test
    fun views_ShouldBe_Gone_AfterVisible() {
        visibilityViews.visible(false)
        assertEquals(View.GONE, visibleView.visibility)
        assertEquals(View.GONE, invisibleView.visibility)
        assertEquals(View.GONE, goneView.visibility)
    }

    @Test
    fun view_ShouldBe_Disabled_AfterDisable() {
        enabledView.disable()
        assertEquals(false, enabledView.isEnabled)
        disabledView.disable()
        assertEquals(false, disabledView.isEnabled)
    }

    @Test
    fun view_ShouldBe_Enabled_AfterEnable() {
        enabledView.enable()
        assertEquals(true, enabledView.isEnabled)
        disabledView.enable()
        assertEquals(true, disabledView.isEnabled)
    }

    @Test
    fun views_ShouldBe_Disabled_AfterDisable() {
        enabledViews.disable()
        assertEquals(false, enabledView.isEnabled)
        assertEquals(false, disabledView.isEnabled)
    }

    @Test
    fun views_ShouldBe_Enabled_AfterEnable() {
        enabledViews.enable()
        assertEquals(true, enabledView.isEnabled)
        assertEquals(true, disabledView.isEnabled)
    }

    @Test
    fun views_ShouldBe_Disabled_AfterEnabled() {
        enabledViews.enabled(false)
        assertEquals(false, enabledView.isEnabled)
        assertEquals(false, disabledView.isEnabled)
    }

    @Test
    fun views_ShouldBe_Enabled_AfterEnabled() {
        enabledViews.enabled()
        assertEquals(true, enabledView.isEnabled)
        assertEquals(true, disabledView.isEnabled)
    }
}