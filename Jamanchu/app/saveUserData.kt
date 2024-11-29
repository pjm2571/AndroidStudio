// Firestore에 사용자 데이터 저장
    private fun saveUserData(user: User) {
        val firestore = FirebaseFirestore.getInstance()

        // 사용자 UID를 Firestore 문서 ID로 사용하여 저장
        firestore.collection("users")
            .document(user.id) // UID를 문서 ID로 사용
            .set(user) // 사용자 객체를 저장
            .addOnSuccessListener {
                Log.d("SignUpActivity", "User data successfully written!")

                // 메인 화면으로 이동
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
            .addOnFailureListener { e ->
                Log.e("SignUpActivity", "Error writing document", e)
            }
    }