import axios from 'axios';

export default function deleteAction(url) {
   axios.delete(url).catch(function (response) {
    alert("Status code: ".concat(response.status) );
  });
}
