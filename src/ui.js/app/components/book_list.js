import React, { Component } from 'react';
import Book from './book';
import Header from './header';

import { connect } from 'react-redux';
import { fetchWeather } from '../actions/index';
import { bindActionCreators } from 'redux';
import * as config from '../config';

class BookList extends Component{
		componentDidMount() {
			this.props.fetchWeather(config.DEFALT_PAGE_SIZE,
															config.DEFALT_PAGE_NUMBER,
															config.DEFALT_SORT_CRITERION);
			}
		render() {
	  if (this.props.weather[0]){
		 var books = this.props.weather[0].map(book =>
		 	<Book key={book.name}
		 				bookProp={book}/>  );
				}
		 return (
			 <table  className="table table-bordered table-hover table-striped" >
        <thead>
							<Header/>
        </thead>
        <tbody>
                {books}
        </tbody>
			</table>
  	)
 	}
}

function mapStateToProps(state) {
  return {
    weather: state.weather,
    selectBook: state.activeBook
   };
}

function mapDispatchToProps(dispatch) {
  return bindActionCreators({ fetchWeather }, dispatch);
}

export default connect(mapStateToProps, mapDispatchToProps)(BookList);
