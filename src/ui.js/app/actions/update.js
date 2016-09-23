import axios from 'axios';
import * as config from '../config';

export default function updateAction(olddata,newdata) {

  const url = olddata._links.self.href;
  var data = new Object();
  Object.keys(newdata).forEach(function(key) {
      if( newdata[key] != olddata[key] ){
        data[key] = newdata[key]
      }
  });

  axios.patch(url,data).catch(function (response) {
   alert("Status code: ".concat(response.status) );
   });
}
