import {initializeApp} from "firebase/app"
import{getAuth} from "firebase/auth"

const firebaseConfig = {
        apiKey: "AIzaSyDpVLrVVtP0xs5Y5iKCVTVwYhxrdE5Mbpo",
        authDomain: "react-a2c2f.firebaseapp.com",
        projectId: "react-a2c2f",
        storageBucket: "react-a2c2f.appspot.com",
        messagingSenderId: "358906805325",
        appId: "1:358906805325:web:16aaeeb875a8befdfcf004"
      };

      

const app=initializeApp(firebaseConfig);
var auth=null;
if(app){
    auth=getAuth();
}

export default auth;