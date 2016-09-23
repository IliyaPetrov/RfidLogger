import * as config from '../config';

export default function(state = config.DEFALT_PAGE_SIZE, action) {
  switch(action.type) {
  case 'SET_PAGE_SIZE':
    return action.payload;
  }

  return state;
}
