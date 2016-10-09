import axios from 'axios';
import * as config from '../config';


export function searchAction(author) {
  const url = `/${config.DEFALT_ENDPOINT}/search/findByAuthorContainingIgnoreCase?author=${author}`;
  const request = axios.get(url, { baseURL: config.DEFALT_BASE_URL, timeout: 1000,
                              validateStatus: function (status) {
                              if (status != 200) { alert("Status code: ".concat(status)) ;}
                              return status == 200; }
                                }).catch(function (response) {
                                  if (response instanceof Error) {
                                    alert(response.message);
                                    }
                                  });

  return {
    type: 'FETCH_WEATHER',
    payload: request
  };
}
