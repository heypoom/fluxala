import processing.core.PConstants._
import processing.core._
import processing.opengl.PShader

class Sketch extends PApplet {
  var cube: PShape = _
  var blueShader: PShader = _
  var angle: Float = 0.0f

  override def settings(): Unit = {
    size(500, 500, P3D)
    pixelDensity(2)
  }

  override def setup(): Unit = {
    blueShader = loadShader("shader.frag")

    cube = createShape(BOX, 50)
    cube.setStroke(color(80))
    cube.setStrokeWeight(4)

    rectMode(CENTER)
  }

  override def draw(): Unit = {
    background(255)

    stroke(60)
    strokeWeight(3)
    ellipse(mouseX, mouseY, 20, 20)

    camera(width / 2, height / 2, mouseY,
      width / 2, height / 2, 0,
      0, 1, 0)

    pointLight(200, 200, 200, width / 2, height / 2, -200)

    translate(width / 2, height / 2)
    rotateX(angle)
    rotateY(angle)
    rotateZ(angle)

    shader(blueShader)
    shape(cube)

    angle += 0.1f
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    PApplet.main("Sketch")
  }
}
