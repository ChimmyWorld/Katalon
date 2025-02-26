import requests
import unittest

BASE_URL = "https://jsonplaceholder.typicode.com"

class APITest(unittest.TestCase):

    def test_get_all_posts(self):
        """ TC01: 전체 게시글 조회 테스트 """
        response = requests.get(f"{BASE_URL}/posts")
        self.assertEqual(response.status_code, 200)
        self.assertTrue(len(response.json()) > 0)  # 최소 한 개 이상의 게시글 존재 확인

    def test_get_single_post(self):
        """ TC02: 특정 게시글 조회 테스트 """
        response = requests.get(f"{BASE_URL}/posts/1")
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json()["id"], 1)  # 요청한 ID와 응답의 ID가 동일해야 함

    def test_create_post(self):
        """ TC03: 게시글 생성 테스트 """
        payload = {
            "title": "테스트 제목",
            "body": "테스트 본문",
            "userId": 1
        }
        response = requests.post(f"{BASE_URL}/posts", json=payload)
        self.assertEqual(response.status_code, 201)  # 201 Created 상태코드 확인
        self.assertEqual(response.json()["title"], payload["title"])  # 데이터가 정상적으로 생성됐는지 확인

    def test_update_post(self):
        """ TC04: 게시글 수정 테스트 """
        payload = {
            "id": 1,
            "title": "수정된 제목",
            "body": "수정된 본문",
            "userId": 1
        }
        response = requests.put(f"{BASE_URL}/posts/1", json=payload)
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json()["title"], payload["title"])  # 제목이 수정됐는지 확인

    def test_delete_post(self):
        """ TC05: 게시글 삭제 테스트 """
        response = requests.delete(f"{BASE_URL}/posts/1")
        self.assertEqual(response.status_code, 200)  # REST API에서는 보통 삭제 성공 시 200 또는 204 반환

if __name__ == "__main__":
    unittest.main()
