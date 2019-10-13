import React from 'react';

import * as rest from './restRequest'

const baseUrl = 'http://127.0.0.1:8080/users'

class MainPage extends React.Component {

    render() {
        return (
          <div>
              <Navibar></Navibar>
              <div className="container-fluid">
              <div className="row d-flex justify-content-center">
                  <div className="col col-md-10">
                      <UserList></UserList>
                  </div>
              </div>
              </div>
          </div>
        )
    }
}

class UserList extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            data: []
        }
    }

    componentDidMount() {
        this.loadUser()
    }

    loadUser() {
        rest.get(baseUrl).then(res => {
            this.setState({
                data: JSON.parse(res)
            })
        })
    }

    render() {
        let users = this.state.data
        let userItems = users.map(user => {
            return <Card key={user.userId} title={user.username}/>
        })

        return (
            <div className="list-group list-group-flush">
                {userItems}
            </div>
        )
    }
}

class Navibar extends React.Component {
    render() {
        return (
            <nav className="navbar navbar-dark bg-dark flex-row-reverse">
                <form className="form-inline" role="search">
                    <div className="input-group">
                        <div className="input-group-prepend">
                            <span className="input-group-text">
                                <i className="fa fa-search"></i>
                            </span>
                        </div>
                        <input type="text" className="form-control" placeholder="Search"/>
                    </div>
                </form>
            </nav>
        )
    }
}

function Card(props) {
    let header
    let footer

    if (props.header) {
        header = (
            <div className="card-header">
                {props.header}
            </div>
        )
    }

    if (props.footer) {
        footer = (
            <div className="card-footer">
                {props.footer}
            </div>
        )
    }


    return (
        <div className="card mb-3">
            {header}
            <div className="card-body">
                <div className="card-title d-flex justify-content-between">
                    <h5>{props.title || "Tourist"}</h5>
                    <small className="text-muted">{props.date}</small>
                </div>
                <p className="card-text">{props.content}</p>
                <p className="card-text">
                    <small className="text-muted">last updated 3 mins ago</small>
                </p>
            </div>
            {footer}
        </div>
    );
}

class Table extends React.Component {
    render() {
        return(
            <div className="table-responsive">
                <table className="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">First</th>
                        <th scope="col">Last</th>
                        <th scope="col">Handle</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td>@mdo</td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Jacob</td>
                        <td>Thornton</td>
                        <td>@fat</td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td colSpan="2">Larry the Bird</td>
                        <td>@twitter</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        )
    }
}

export default MainPage