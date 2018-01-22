package com.mjw.enum1.test;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<5;i++){
			String name = Color.getName(i);
			System.out.println(name);
		}
		
		System.out.println(Color.RED.name);
	}

	public enum Color {
		RED("��ɫ", 1), GREEN("��ɫ", 2), BLANK("��ɫ", 3), YELLO("��ɫ", 4);
		// ��Ա����
		private String name;
		private int index;

		// ���췽��
		private Color(String name, int index) {
			this.name = name;
			this.index = index;
		}

		// ��ͨ����
		public static String getName(int index) {
			for (Color c : Color.values()) {
				if (c.getIndex() == index) {
					return c.name;
				}
			}
			return null;
		}

		// get set ����
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}
	}

}