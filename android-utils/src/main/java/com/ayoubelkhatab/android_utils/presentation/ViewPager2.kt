package com.ayoubelkhatab.android_utils.presentation

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

object ViewPager2Transformations {

    class AntiClockSpin : ViewPager2.PageTransformer {
        override fun transformPage(page: View, position: Float) {
            page.translationX = -position * page.width

            if (abs(position) < 0.5) {
                page.visibility = View.VISIBLE
                page.scaleX = 1 - abs(position)
                page.scaleY = 1 - abs(position)
            } else if (abs(position) > 0.5) {
                page.visibility = View.GONE
            }

            if (position < -1) {  // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f

            } else if (position <= 0) {    // [-1,0]
                page.alpha = 1f
                page.rotation = 360 * (1 - abs(position))

            } else if (position <= 1) {    // (0,1]
                page.alpha = 1f
                page.rotation = -360 * (1 - abs(position))

            } else {  // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f
            }
        }

        companion object {
            val instance: AntiClockSpin = AntiClockSpin()
        }
    }

    class ClockSpin : ViewPager2.PageTransformer {
        override fun transformPage(page: View, position: Float) {
            page.translationX = -position * page.width

            if (abs(position) <= 0.5) {
                page.visibility = View.VISIBLE
                page.scaleX = 1 - abs(position)
                page.scaleY = 1 - abs(position)
            } else if (abs(position) > 0.5) {
                page.visibility = View.GONE
            }


            if (position < -1) {  // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f

            } else if (position <= 0) {   // [-1,0]
                page.alpha = 1f
                page.rotation = 360 * abs(position)

            } else if (position <= 1) {   // (0,1]
                page.alpha = 1f
                page.rotation = -360 * abs(position)

            } else {  // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f

            }
        }

        companion object {
            val instance: ClockSpin = ClockSpin()
        }
    }

    class CubeInDepth : ViewPager2.PageTransformer {
        companion object {
            val instance: CubeInDepth = CubeInDepth()
        }

        override fun transformPage(page: View, position: Float) {
            page.cameraDistance = 20000f


            if (position < -1) {
                page.alpha = 0f
            } else if (position <= 0) {
                page.alpha = 1f
                page.pivotX = page.width.toFloat()
                page.rotationY = 90 * abs(position)
            } else if (position <= 1) {
                page.alpha = 1f
                page.pivotX = 0f
                page.rotationY = -90 * abs(position)
            } else {
                page.alpha = 0f
            }


            val max = Math.max(.4f, 1 - abs(position))
            if (abs(position) <= 0.5) {
                page.scaleY = max
            } else if (abs(position) <= 1) {
                page.scaleY = max
            }
        }
    }

    class CubeInRotation : ViewPager2.PageTransformer {
        companion object {
            val instance: CubeInRotation = CubeInRotation()
        }

        override fun transformPage(page: View, position: Float) {
            page.cameraDistance = 20000f


            if (position < -1) {     // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f

            } else if (position <= 0) {    // [-1,0]
                page.alpha = 1f
                page.pivotX = page.width.toFloat()
                page.rotationY = 90 * abs(position)

            } else if (position <= 1) {    // (0,1]
                page.alpha = 1f
                page.pivotX = 0f
                page.rotationY = -90 * abs(position)

            } else {    // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f

            }
        }
    }

    class CubeInScaling : ViewPager2.PageTransformer {
        companion object {
            val instance: CubeInScaling = CubeInScaling()
        }

        override fun transformPage(page: View, position: Float) {
            page.cameraDistance = 20000f


            if (position < -1) {     // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f

            } else if (position <= 0) {    // [-1,0]
                page.alpha = 1f
                page.pivotX = page.width.toFloat()
                page.rotationY = 90 * abs(position)

            } else if (position <= 1) {    // (0,1]
                page.alpha = 1f
                page.pivotX = 0f
                page.rotationY = -90 * abs(position)

            } else {    // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f

            }



            if (abs(position) <= 0.5) {
                page.scaleY = Math.max(.4f, 1 - abs(position))
            } else if (abs(position) <= 1) {
                page.scaleY = Math.max(.4f, abs(position))

            }
        }
    }

    class CubeOutDepth : ViewPager2.PageTransformer {
        companion object {
            val instance: CubeOutDepth = CubeOutDepth()
        }

        override fun transformPage(page: View, position: Float) {
            if (position < -1) {    // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f

            } else if (position <= 0) {    // [-1,0]
                page.alpha = 1f
                page.pivotX = page.width.toFloat()
                page.rotationY = -90 * abs(position)

            } else if (position <= 1) {    // (0,1]
                page.alpha = 1f
                page.pivotX = 0f
                page.rotationY = 90 * abs(position)

            } else {    // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f

            }



            if (abs(position) <= 0.5) {
                page.scaleY = Math.max(0.4f, 1 - abs(position))
            } else if (abs(position) <= 1) {
                page.scaleY = Math.max(0.4f, 1 - abs(position))
            }
        }
    }

    class CubeOutRotation : ViewPager2.PageTransformer {
        companion object {
            val instance: CubeOutRotation = CubeOutRotation()
        }

        override fun transformPage(page: View, position: Float) {
            if (position < -1) {    // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f

            } else if (position <= 0) {    // [-1,0]
                page.alpha = 1f
                page.pivotX = page.width.toFloat()
                page.rotationY = -90 * abs(position)

            } else if (position <= 1) {    // (0,1]
                page.alpha = 1f
                page.pivotX = 0f
                page.rotationY = 90 * abs(position)

            } else {    // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f
            }
        }
    }

    class CubeOutScaling : ViewPager2.PageTransformer {
        companion object {
            val instance: CubeOutScaling = CubeOutScaling()
        }

        override fun transformPage(page: View, position: Float) {
            if (position < -1) {    // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f

            } else if (position <= 0) {    // [-1,0]
                page.alpha = 1f
                page.pivotX = page.width.toFloat()
                page.rotationY = -90 * abs(position)

            } else if (position <= 1) {    // (0,1]
                page.alpha = 1f
                page.pivotX = 0f
                page.rotationY = 90 * abs(position)

            } else {    // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f

            }



            if (abs(position) <= 0.5) {
                page.scaleY = Math.max(0.4f, 1 - abs(position))
            } else if (abs(position) <= 1) {
                page.scaleY = Math.max(0.4f, abs(position))
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    class DepthPage : ViewPager2.PageTransformer {
        companion object {
            val instance: DepthPage = DepthPage()
        }

        private val MIN_SCALE = 0.75f
        override fun transformPage(page: View, position: Float) {
            val pageWidth: Int = page.width

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f
            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                page.alpha = 1f
                page.translationX = 0f
                page.translationZ = 0f
                page.scaleX = 1f
                page.scaleY = 1f
            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                page.alpha = 1 - position

                // Counteract the default slide transition
                page.translationX = pageWidth * -position
                // Move it behind the left page
                page.translationZ = -1f

                // Scale the page down (between MIN_SCALE and 1)
                val scaleFactor = (MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - abs(position)))
                page.scaleX = scaleFactor
                page.scaleY = scaleFactor
            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f
            }
        }

    }

    class Depth : ViewPager2.PageTransformer {
        companion object {
            val instance: Depth = Depth()
        }

        override fun transformPage(page: View, position: Float) {
            if (position < -1) {    // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f

            } else if (position <= 0) {    // [-1,0]
                page.alpha = 1f
                page.translationX = 0f
                page.scaleX = 1f
                page.scaleY = 1f

            } else if (position <= 1) {    // (0,1]
                page.translationX = -position * page.width
                page.alpha = 1 - abs(position)
                page.scaleX = 1 - abs(position)
                page.scaleY = 1 - abs(position)

            } else {    // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f

            }
        }
    }

    class FadeOut : ViewPager2.PageTransformer {
        companion object {
            val instance: FadeOut = FadeOut()
        }

        override fun transformPage(page: View, position: Float) {
            page.translationX = -position * page.width

            page.alpha = 1 - abs(position)
        }
    }

    class Fan : ViewPager2.PageTransformer {
        companion object {
            val instance: Fan = Fan()
        }

        override fun transformPage(page: View, position: Float) {
            page.translationX = -position * page.width
            page.pivotX = 0f
            page.pivotY = page.height / 2f
            page.cameraDistance = 20000f

            if (position < -1) {     // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f

            } else if (position <= 0) {    // [-1,0]
                page.alpha = 1f
                page.rotationY = -120 * abs(position)
            } else if (position <= 1) {    // (0,1]
                page.alpha = 1f
                page.rotationY = 120 * abs(position)

            } else {    // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f

            }
        }
    }

    class FidgetSpin : ViewPager2.PageTransformer {
        companion object {
            val instance: FidgetSpin = FidgetSpin()
        }

        override fun transformPage(page: View, position: Float) {
            page.translationX = -position * page.width

            if (abs(position) < 0.5) {
                page.visibility = View.VISIBLE
                page.scaleX = 1 - abs(position)
                page.scaleY = 1 - abs(position)
            } else if (abs(position) > 0.5) {
                page.visibility = View.GONE
            }

            if (position < -1) {     // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f

            } else if (position <= 0) {    // [-1,0]
                page.alpha = 1f
                page.rotation =
                    36000 * (abs(position) * abs(position) * abs(position) * abs(position) * abs(
                        position
                    ) * abs(position) * abs(position))

            } else if (position <= 1) {    // (0,1]
                page.alpha = 1f
                page.rotation =
                    -36000 * (abs(position) * abs(position) * abs(position) * abs(position) * abs(
                        position
                    ) * abs(position) * abs(position))

            } else {    // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f

            }
        }
    }

    class Gate : ViewPager2.PageTransformer {
        companion object {
            val instance: Gate = Gate()
        }

        override fun transformPage(page: View, position: Float) {
            page.translationX = -position * page.width

            if (position < -1) {    // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f

            } else if (position <= 0) {    // [-1,0]
                page.alpha = 1f
                page.pivotX = 0f
                page.rotationY = 90 * abs(position)

            } else if (position <= 1) {    // (0,1]
                page.alpha = 1f
                page.pivotX = page.width.toFloat()
                page.rotationY = -90 * abs(position)

            } else {    // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f

            }

        }
    }

    class HorizontalFlip : ViewPager2.PageTransformer {
        companion object {
            val instance: HorizontalFlip = HorizontalFlip()
        }

        override fun transformPage(page: View, position: Float) {
            page.translationX = -position * page.width
            page.cameraDistance = 12000f

            if (position < 0.5 && position > -0.5) {
                page.visibility = View.VISIBLE
            } else {
                page.visibility = View.INVISIBLE
            }


            if (position < -1) {     // [-Infinity,-1)
                page.alpha = 0f

            } else if (position <= 0) {    // [-1,0]
                page.alpha = 1f
                page.rotationY = 180 * (1 - abs(position) + 1)

            } else if (position <= 1) {    // (0,1]
                page.alpha = 1f
                page.rotationY = -180 * (1 - abs(position) + 1)

            } else {
                page.alpha = 0f
            }
        }
    }

    class VerticalFlip : ViewPager2.PageTransformer {
        companion object {
            val instance: VerticalFlip = VerticalFlip()
        }

        override fun transformPage(page: View, position: Float) {
            page.translationX = -position * page.width
            page.cameraDistance = 20000f

            if (position < 0.5 && position > -0.5) {
                page.visibility = View.VISIBLE
            } else {
                page.visibility = View.INVISIBLE
            }



            if (position < -1) {     // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f

            } else if (position <= 0) {    // [-1,0]
                page.alpha = 1f
                page.rotationX = 180 * (1 - abs(position) + 1)

            } else if (position <= 1) {    // (0,1]
                page.alpha = 1f
                page.rotationX = -180 * (1 - abs(position) + 1)

            } else {    // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f

            }
        }
    }

    class Pop : ViewPager2.PageTransformer {
        companion object {
            val instance: Pop = Pop()
        }

        override fun transformPage(page: View, position: Float) {
            page.translationX = -position * page.width

            if (abs(position) < 0.5) {
                page.visibility = View.VISIBLE
                page.scaleX = 1 - abs(position)
                page.scaleY = 1 - abs(position)
            } else if (abs(position) > 0.5) {
                page.visibility = View.GONE
            }
        }
    }

    class Spinner : ViewPager2.PageTransformer {
        companion object {
            val instance: Spinner = Spinner()
        }

        override fun transformPage(page: View, position: Float) {
            page.translationX = -position * page.width
            page.cameraDistance = 12000f

            if (position < 0.5 && position > -0.5) {
                page.visibility = View.VISIBLE
            } else {
                page.visibility = View.INVISIBLE
            }



            if (position < -1) {     // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f

            } else if (position <= 0) {    // [-1,0]
                page.alpha = 1f
                page.rotationY = 900 * (1 - abs(position) + 1)

            } else if (position <= 1) {    // (0,1]
                page.alpha = 1f
                page.rotationY = -900 * (1 - abs(position) + 1)

            } else {    // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f

            }
        }
    }

    class Toss : ViewPager2.PageTransformer {
        companion object {
            val instance: Toss = Toss()
        }

        override fun transformPage(page: View, position: Float) {
            page.translationX = -position * page.width
            page.cameraDistance = 20000f


            if (position < 0.5 && position > -0.5) {
                page.visibility = View.VISIBLE

            } else {
                page.visibility = View.INVISIBLE

            }


            if (position < -1) {     // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f

            } else if (position <= 0) {    // [-1,0]
                page.alpha = 1f
                page.scaleX = Math.max(0.4f, (1 - abs(position)))
                page.scaleY = Math.max(0.4f, (1 - abs(position)))
                page.rotationX = 1080 * (1 - abs(position) + 1)
                page.translationY = -1000 * abs(position)

            } else if (position <= 1) {    // (0,1]
                page.alpha = 1f
                page.scaleX = Math.max(0.4f, (1 - abs(position)))
                page.scaleY = Math.max(0.4f, (1 - abs(position)))
                page.rotationX = -1080 * (1 - abs(position) + 1)
                page.translationY = -1000 * abs(position)

            } else {    // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f

            }
        }
    }

    class VerticalShut : ViewPager2.PageTransformer {
        companion object {
            val instance: VerticalShut = VerticalShut()
        }

        override fun transformPage(page: View, position: Float) {
            page.translationX = -position * page.width
            page.cameraDistance = 999999999f

            if (position < 0.5 && position > -0.5) {
                page.visibility = View.VISIBLE
            } else {
                page.visibility = View.INVISIBLE
            }

            if (position < -1) {     // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f

            } else if (position <= 0) {    // [-1,0]
                page.alpha = 1f
                page.rotationX = 180 * (1 - abs(position) + 1)

            } else if (position <= 1) {    // (0,1]
                page.alpha = 1f
                page.rotationX = -180 * (1 - abs(position) + 1)

            } else {    // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f

            }
        }
    }

    class ZoomOutPage : ViewPager2.PageTransformer {
        companion object {
            val instance: ZoomOutPage = ZoomOutPage()
        }

        private val MIN_SCALE = 0.85f
        private val MIN_ALPHA = 0.5f
        override fun transformPage(page: View, position: Float) {
            val pageWidth: Int = page.width
            val pageHeight: Int = page.height

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f
            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                val scaleFactor =
                    Math.max(MIN_SCALE, 1 - abs(position))
                val verticalMargin = pageHeight * (1 - scaleFactor) / 2
                val horizontalMargin = pageWidth * (1 - scaleFactor) / 2
                if (position < 0) {
                    page.translationX = horizontalMargin - verticalMargin / 2
                } else {
                    page.translationX = -horizontalMargin + verticalMargin / 2
                }

                // Scale the page down (between MIN_SCALE and 1)
                page.scaleX = scaleFactor
                page.scaleY = scaleFactor

                // Fade the page relative to its size.
                page.alpha = MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                        (1 - MIN_SCALE) * (1 - MIN_ALPHA)
            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f
            }
        }
    }
}