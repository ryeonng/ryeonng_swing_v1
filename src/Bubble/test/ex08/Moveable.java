package Bubble.test.ex08;

public interface Moveable {

	// public abstract 생략 가능
	public abstract void left();

	public abstract void right();

	public abstract void up();

	// 인터페이스 추가 기능 default 사용해보기
	// 인터페이스의 모든 메서드는 추상 메서드여야 한다.
	// ( 단, default 메서드를 제외 하고 )
	default void down() {
	};
	// 마지막에 있는 default는 세미콜론을 추가해야 한다.

}
