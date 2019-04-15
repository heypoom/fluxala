import processing.core._
import processing.opengl.PShader

class Sketch extends PApplet {
  var blueShader: PShader = _

  override def settings(): Unit = {
    size(500, 500, PConstants.P3D)
    pixelDensity(2)
  }

  override def setup(): Unit = {
    blueShader = loadShader("shader.frag")
  }

  override def draw(): Unit = {
    background(255)

    stroke(60)
    strokeWeight(3)
    shader(blueShader)
    ellipse(mouseX, mouseY, 200, 200)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    PApplet.main("Sketch")
  }
}
