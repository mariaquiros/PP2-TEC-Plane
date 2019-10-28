package Objetos;

/**
 * 
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneChatOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.Utterance;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.UtteranceAnalyses;

public class ToneAnalizer {
	private String apikey = "CXngFyZj8ORsJ9bUY2Bow-8JSbmxU6MF_fEO0KmLf24q";
	private String url = "https://gateway.watsonplatform.net/tone-analyzer/api";
	private String version = "2017-09-21";
	
	public ToneAnalizer() {}
	
	public UtteranceAnalyses analyze(String message) {
		IamOptions options = new IamOptions.Builder()
				  .apiKey(apikey)
				  .build();

				ToneAnalyzer toneAnalyzer = new ToneAnalyzer("2017-09-21", options);
				toneAnalyzer.setEndPoint(url);

				Utterance utterance = new Utterance.Builder()
				  .text(message)
				  .build();
				
				ToneChatOptions toneChatOptions = new ToneChatOptions.Builder()
				  .addUtterances(utterance)
				  .build();

				UtteranceAnalyses utteranceAnalyses = 
				  toneAnalyzer.toneChat(toneChatOptions).execute();
				return utteranceAnalyses;
				
	}
	
	public JSONArray getFeelings(String message) {
		UtteranceAnalyses utteranceAnalyses=analyze(message);
		JSONObject feel=null;
		JSONArray feelings= new JSONArray() ;
		
		for (int i=0;i<utteranceAnalyses.getUtterancesTone().get(0).getTones().size();i++) {
			try {
				feel= new JSONObject();
				feel.put("feel",utteranceAnalyses.getUtterancesTone().get(0).getTones().get(i).getToneName());
				feelings.put(feel);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return feelings;
	}
	
}
