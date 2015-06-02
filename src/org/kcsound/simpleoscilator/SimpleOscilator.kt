import com.google.gson.JsonObject;

class SimpleOscilator : Instrument {
  override val type: String = "SimpleOscilator";

  /**
   * Generate body content.
   */
  override public fun body():String {
    return """
             krnd  randomh 40, 440, 1	; produce random values
             ain   poscil3 .6, krnd, giSine
             kline line    1, p3, 0    	; straight line
             aL,aR pan2    ain, kline	; sent across image
                   outs    aL, aR
         """
  }

  /**
   * Generate globals to be added to the score.
   */
  override public fun  globals():String {
    return "giSine ftgen 0, 0, 2^10, 10, 1";
  }

  /**
   * Compiles the instrument.
   */
   override public fun compile(data:JsonObject) {

   }
}
