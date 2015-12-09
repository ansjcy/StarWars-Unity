using UnityEngine;
using System.Collections;

public class ButtonFire : MonoBehaviour {
	public static bool fire = false;

	void OnEnable(){
		EasyButton.On_ButtonDown += On_ButtonDown;	
		EasyButton.On_ButtonPress += On_ButtonPress;
		EasyButton.On_ButtonUp += On_ButtonUp;
	}
	
	void OnDisable(){
		EasyButton.On_ButtonDown -= On_ButtonDown;	
		EasyButton.On_ButtonPress -= On_ButtonPress;
		EasyButton.On_ButtonUp -= On_ButtonUp;		
	}
	
	void OnDestroy(){
		EasyButton.On_ButtonDown -= On_ButtonDown;	
		EasyButton.On_ButtonPress -= On_ButtonPress;
		EasyButton.On_ButtonUp -= On_ButtonUp;			
	}
	
	void On_ButtonDown( string buttonName){
		if (buttonName == "ButtonFire") {
			Debug.Log ("button down!!");
			fire = true;	
		}
	}
	
	void On_ButtonPress( string buttonName){}
	
	void On_ButtonUp( string buttonName){
		if (buttonName == "ButtonFire") {
			Debug.Log ("button up!!");
			fire = false;	
		}
	}
}
