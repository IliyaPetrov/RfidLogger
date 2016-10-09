import axios from 'axios';
import * as config from '../config';

export default function createAction(data) {
  const url = `${config.DEFALT_BASE_URL}/${config.DEFALT_ENDPOINT}`
   axios.post(url,data).catch(function (response) {
    alert("Status code: ".concat(response.status) );
  });
}
