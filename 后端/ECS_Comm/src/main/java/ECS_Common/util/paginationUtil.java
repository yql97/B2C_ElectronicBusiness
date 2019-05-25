/**
 * 
 */
package ECS_Common.util;

/**
 * @author yueqiulin
 *
 */
public class paginationUtil {
          private  int start;
          private int last;
          private Object o;
          
		public paginationUtil(int start, int last, Object o) {
			super();
			this.start = start;
			this.last = last;
			this.o = o;
		}
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getLast() {
			return last;
		}
		public void setLast(int last) {
			this.last = last;
		}
		public Object getO() {
			return o;
		}
		public void setO(Object o) {
			this.o = o;
		}
          
}
