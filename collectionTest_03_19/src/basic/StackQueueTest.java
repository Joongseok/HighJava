package basic;

import java.util.LinkedList;

public class StackQueueTest {
	public static void main(String[] args) {
		/*
			Stack ==> 후입선출(LIFO)의 자료 구조
			Queue ==> 선입선출(FIFO)의 자료 구조 
			
			 Stack과 Queue는 LinkedList를 이용하여 사용할 수 있다.
		*/
		
		
		/*
		 *  Stack에서 사용되는 명령어
		 *  1. 자료 추가 : push(추가할데이터)
		 *  2. 자료 출력 : pop() ==> 자료를 꺼내온 후 꺼내온 자료를 Stack에서 지운다.
		 *  3. 자료 확인 : peek() ==> 삭제없이 자료를 꺼내온다,
		*/
		
		LinkedList<String> stack = new LinkedList<String>();
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("강감찬");
		stack.push("이순신");
		System.out.println("현재 Stack ==> " + stack );
		
		String data = stack.pop();
		System.out.println("꺼내온 자료 : " + data);
		System.out.println("꺼내온 자료 : " + stack.pop());
		System.out.println("현재 Stack ==> " + stack);
		
		stack.push("성춘향");
		System.out.println("현재 Stack ==> " + stack);
		System.out.println("꺼내온 자료 : " + stack.pop());
		System.out.println("현재 Stack ==> " + stack);
		System.out.println("꺼내온 자료(peek) : " + stack.peek());
		System.out.println("현재 Stack ==> " + stack);
		
		System.out.println("-------------------------------");
		System.out.println();
		
		/*
		 * Queue명령어
		 * 1. 자료 입력 : offer(추가할데이터)
		 * 2. 자료 출력 : poll() ==> 자료를 Queue에서 꺼내온 후 꺼내온 자료를 삭제한다.
		 * 3. 자료 확인 : peek()
		*/
		LinkedList<String> queue = new LinkedList<String>();
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("강감찬");
		queue.offer("이순신");
		
		System.out.println("현재 queue => " + queue);
		String temp = queue.poll();
		System.out.println("꺼내온 자료 : " + temp);
		System.out.println("꺼내온 자료 : " + queue.poll());
		System.out.println("현재 queue => " + queue);
		
		queue.offer("성춘향");
		System.out.println("현재 queue => " + queue);
		System.out.println("꺼내온 자료 : " + queue.poll());
		System.out.println("현재 queue => " + queue);
		System.out.println("꺼내온 자료(peek) : " + queue.peek());
		System.out.println("현재 queue => " + queue);
		
	}
}
