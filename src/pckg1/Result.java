package pckg1;

public class Result {
	
	private String result;
	private String resultText;
	private String resultScreenshot;
	public Result(String result,String resultText,String resultscreenshot) {
		this.result = result;
		this.resultText = resultText;
		this.resultScreenshot = resultscreenshot;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getResult() {
		return this.result;
	}
	
	public void setResultText(String resultText) {
		this.resultText = resultText;
	}
	
	public String getResultText() {
		return this.resultText;
	}
	
	public String getResultScreenshot()
	{
		return this.resultScreenshot;
	}
	public void setResultScreenshot(String resultScreenshot) {
		this.resultScreenshot = resultScreenshot;
	}

}