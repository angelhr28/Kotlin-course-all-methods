///////////////////////////////////////////////////antes/////////////////////////////////////////////7
fun logVideoQuartile(percentComplete: Int?) {
   if (percentComplete == null) {
       return
   }
   val quartile: Int
   val percentQuartile: Float
   if (percentComplete >= 0 && percentComplete < 25) {
       quartile = 0
       percentQuartile = 0f
   } else if (percentComplete >= 25 && percentComplete < 50) {
       quartile = 1
       percentQuartile = .25f
   } else if (percentComplete >= 50 && percentComplete < 75) {
       quartile = 2
       percentQuartile = .50f
   } else if (percentComplete >= 75 && percentComplete < 95) {
       quartile = 3
       percentQuartile = .75f
   } else if (percentComplete >= 95 && percentComplete < 97) {
       quartile = 3
       percentQuartile = .95f
   } else if (percentComplete >= 97 && percentComplete < 100) {
       quartile = 3
       percentQuartile = .97f
   } else if (percentComplete == 100) {
       quartile = 4
       percentQuartile = 1f
   } else {
       quartile = -1
       percentQuartile = -1f
   }
   println(" Quartile is $quartile and percent quartile is $percentQuartile")
}




///////////////////////////////////////////////////despues/////////////////////////////////////////////7
fun logVideoQuartile(percentComplete: Int?) {
  percentComplete.let{
       return
   }
    var (quartile, percentQuartile ) =
    when(percentComplete){
        in 0 until 25-> Pair(0,0f)
    	in 25 until 50 -> Pair( 1,.25f)
        in 50 until 75 ->Pair (2,.50f)
        in 75 until 95->Pair(3,.75f)
        in 95 until 97 ->Pair(3,.95f)
        in 97 until 100 -> Pair(3,.97f)
        100 ->Pair( 4,1f)
        else -> Pair(-1,-1f)
    }
       
   println(" Quartile is $quartile and percent quartile is $percentQuartile")
  
}   
