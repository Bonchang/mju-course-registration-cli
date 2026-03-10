package presentation;

import java.util.Vector;
import valueObject.VLecture;

public class PLectureBasket {

    private Vector<VLecture> vLectureVector;

    public PLectureBasket() {
        vLectureVector = new Vector<VLecture>();
    }

    public void add(VLecture vLecture) {
        vLectureVector.add(vLecture);
    }

    public Vector<VLecture> getVLectureVector() {
        return vLectureVector;
    }

    public void show() {
        if (vLectureVector.isEmpty()) {
            System.out.println("비어있는 상태입니다.");
        } else {
            for (int i = 0; i < vLectureVector.size(); i++) {
                System.out.println((i + 1) + ". " + vLectureVector.get(i).getTitle());
            }
        }
    }

    
    // 강좌 삭제
    public void remove(int index) {
        if (index >= 0 && index < vLectureVector.size()) {
            vLectureVector.remove(index);
            System.out.println("강좌를 삭제했습니다.");
        } else {
            System.out.println("유효하지 않은 인덱스입니다.");
        }
    }
}
