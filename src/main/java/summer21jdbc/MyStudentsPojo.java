package summer21jdbc;

public class MyStudentsPojo {

		private int std_age;
		private String std_name;
		
		
		public MyStudentsPojo() {

		
		}


		public MyStudentsPojo(int std_age, String std_name) {

			this.std_age = std_age;
			this.std_name = std_name;
		}


		public int getStd_age() {
			return std_age;
		}


		public void setStd_age(int std_age) {
			this.std_age = std_age;
		}


		public String getStd_name() {
			return std_name;
		}


		public void setStd_name(String std_name) {
			this.std_name = std_name;
		}


		@Override
		public String toString() {
			return "MyStudentsPojo : std_age=" + std_age + ", std_name=" + std_name;
		}
		
		
}
