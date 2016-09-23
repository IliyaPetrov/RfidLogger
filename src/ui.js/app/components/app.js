import React, { Component } from 'react';
import BookList from './book_list';

export default class App extends Component{
	render() {
	 	return (
			<div className="panel panel-default">
				<div className="panel-heading">Отчитане на работното време</div>
									<BookList/>
			</div>
			)
 	 }
}
