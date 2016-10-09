import React, { Component } from 'react';
import ReactDOM from 'react-dom';

import App from './components/app';
import { Provider } from 'react-redux';
import ReduxPromise from 'redux-promise';
import { createStore, applyMiddleware } from 'redux';
import reducers from './reducers';

const bookListWithMiddleware = applyMiddleware(ReduxPromise)(createStore);

ReactDOM.render(
	<Provider store={bookListWithMiddleware(reducers)}>
	<App/>
	</Provider>,
  document.querySelector('.container')
);
