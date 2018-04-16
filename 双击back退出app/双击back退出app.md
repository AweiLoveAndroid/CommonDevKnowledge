# 双击back返回键退出app功能的实现方式

有两种实现思路，看个人喜好吧：

### 方式1：


	public class MainActivity extends Activity {

		private Toast toast;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			toast = Toast.makeText(getApplicationContext(), "确定退出？", 0);
		}

		public void onBackPressed() {
			quitToast();
		}

		private void quitToast() {
			if(null == toast.getView().getParent()) {
				toast.show();
			}else{
				System.exit(0);
			}
		}
	}


### 方式2：

	public class MainActivity extends Activity {

		private Toast toast;
		rotected void onCreate(Bundle savedInstanceState) {
		 	...
		         toast = Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT);
		        toast.setGravity(Gravity.BOTTOM, 0, ConversionUtil.dip2px(this, 150));
		}

		@Override 
		public void onBackPressed() { 
		    if (doubleBackToExitPressedOnce) { 
		        if(toast!=null){
		            toast.cancel();
		        }
		        super.onBackPressed(); 
		        return; 
		    } 
		 
		    this.doubleBackToExitPressedOnce = true;
		    toast.show();
		 
		    new Handler().postDelayed(new Runnable() {
		 
		        @Override 
		        public void run() { 
		            doubleBackToExitPressedOnce=false;                        
		        } 
		    }, 2000); 
		} 
	}