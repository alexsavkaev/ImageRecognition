import org.jetbrains.kotlinx.dl.api.inference.TensorFlowInferenceModel
import org.jetbrains.kotlinx.dl.dataset.embedded.fashionMnist
import java.io.File
import kotlin.random.Random

fun main() {
    val stringLabels = mapOf(0 to "T-shirt/top",
        1 to "Trousers",
        2 to "Pullover",
        3 to "Dress",
        4 to "Coat",
        5 to "Sandals",
        6 to "Shirt",
        7 to "Sneakers",
        8 to "Bag",
        9 to "Ankle boots"
    )
    val imageID: Int = Random.nextInt(0,10000)
    val (train, test) = fashionMnist()
    TensorFlowInferenceModel.load(File("model/my_model")).use{
        it.reshape(28,28,1)
        val prediction = it.predict(test.getX(imageID))
        val actualLabel = test.getY(imageID)
        println("Predicted label is: $prediction. This corresponds to class ${stringLabels[prediction]} ")
        println("Actual label is: $actualLabel")
    }
}