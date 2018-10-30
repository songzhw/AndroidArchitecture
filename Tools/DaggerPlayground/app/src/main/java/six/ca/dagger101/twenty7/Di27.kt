package six.ca.dagger101.twenty7

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

class Bamboo @Inject constructor()

class Panda(val bamboo: Bamboo)

class Apple

@Module
class SichuangModule {
	//参数bamboo已经由@inject constructor提供了
	@Provides
	fun panda(bamboo: Bamboo, apple: Apple): Panda {
		return Panda(bamboo)
	}
}

@Component(modules = [SichuangModule::class])
interface SichuangComponent {
	@Component.Builder
	interface Builder{
		fun build() : SichuangComponent
		@BindsInstance fun apple(apple: Apple) : Builder
	}
}

class Twenty7Activity : AppCompatActivity(){
	@Inject lateinit var panda : Panda

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		DaggerSichuangComponent.builder()
				.apple(Apple())
				.build()

		println("szw panda = $panda")
	}
}