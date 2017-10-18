package prepare.byounghong.prepare.model

/**
 * Created by byounghong on 2017. 10. 17..
 */


/* data class
    1개 이상의 파라미터가 반드시 존재해야함
    toString() / copy() / equals() / hashcode()를 쌍으로 자동 생성
    선언된 property에 상응하는 conponentN() 함수 생성
 */
data class User (
    val id : Int,
    val name: String,
    val email: String
)