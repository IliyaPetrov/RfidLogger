import * as config from '../config';

export default function(state = config.DEFALT_SORT_CRITERION, action) {
  switch(action.type) {
  case 'SORT_BY':
    return action.payload;
  }

  return state;
}
