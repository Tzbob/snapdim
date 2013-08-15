package org.snapdim

import com.github.sarxos.webcam.Webcam
import java.awt.Color
import java.awt.image.BufferedImage
import scala.sys.process._

object DimBacklight extends App {

  /**
   * http://en.wikipedia.org/wiki/Luminance_(relative)
   */
  def getLuminance(color: Color): Double = {
    val Array(r, g, b) = color.getRGBColorComponents(null)
    (0.2126 * r + 0.7152 * g + 0.0722 * b) * 100
  }

  def getLumAvg(image: BufferedImage): Double = {
    val luminances = for {
      x <- 0 until image.getWidth
      y <- 0 until image.getHeight
      pixel = new Color(image.getRGB(x, y))
    } yield (getLuminance(pixel))

    luminances.sum / luminances.length
  }

  val cam = Webcam.getDefault

  cam.open()
  val sampleLumAvg = for (_ <- 1 to 10) yield (getLumAvg(cam.getImage))
  cam.close()

  val avgLum = sampleLumAvg.sum / sampleLumAvg.length

  s"xbacklight -set $avgLum".!
}