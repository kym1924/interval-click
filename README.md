<div>
<img src="https://img.shields.io/badge/Android-3DDC84?style=flat&logo=Android&logoColor=white" />
<img src="https://img.shields.io/badge/Kotlin-7F52FF?style=flat&logo=Kotlin&logoColor=white" />
<img src="https://img.shields.io/badge/writer-kym1924-yellow?&style=flat&logo=Android"/>
</div>

# Click Listener with an interval of 2 seconds

#### 1. Initialize
```kotlin
abstract class IntervalClickListener : View.OnClickListener {
    private var lastClickTime: Long = 0
    abstract fun onIntervalClick()

    override fun onClick(v: View?) {
        // TODO
    }

    companion object {
        const val INTERVAL = 2000
    }
}
```
<br>

#### 2. Check the time when a click event is inputted.
```kotlin
override fun onClick(v: View?) {
    val currentClickTime = SystemClock.uptimeMillis()   
}
```
<br>

#### 3. Compare with last click time.
```kotlin
override fun onClick(v: View?) {
    val currentClickTime = SystemClock.uptimeMillis()   
    val diffTime = currentClickTime - lastClickTime
}
```
<br>

#### 4. Run if the calculated time is less than 2 seconds.
```kotlin
override fun onClick(v: View?) {
    val currentClickTime = SystemClock.uptimeMillis()   
    val diffTime = currentClickTime - lastClickTime
    
    if(diffTime > INTERVAL) {
        onIntervalClick()
    }
}
```
<br>

#### 5. Save current time at lastClickTime.
```kotlin
override fun onClick(v: View?) {
    val currentClickTime = SystemClock.uptimeMillis()   
    val diffTime = currentClickTime - lastClickTime
    
    if(diffTime > INTERVAL) {
        onIntervalClick()
        lastClickTime = currentClickTime
    }
}
```
<br>

#### 6. Extension
```kotlin
fun View.setIntervalClickListener(onClick: () -> Unit) {
    this.setOnClickListener(object : IntervalClickListener() {
        override fun onIntervalClick() {
            onClick()
        }
    })
}
```
<br>

#### 7. Usage example
```kotlin
private fun setBtnLogClickListener() {
    binding.btnLog.setIntervalClickListener {
        Timber.d(currentTimeFormat())
    }
}

private fun currentTimeFormat() =
	SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.KOREA).format(System.currentTimeMillis())
```
<img src="https://user-images.githubusercontent.com/63637706/136518026-125d3b55-932a-440a-99a0-8035b9b0dc4f.PNG"/>
