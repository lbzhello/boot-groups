import React from 'react';

import * as rest from './restRequest'

const baseUrl = 'http://127.0.0.1:8080/user'

class MainPage extends React.Component {
  render() {
    return (
      <div>
          <Navibar></Navibar>
          <List></List>
          <Table></Table>
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
        return (
            <nav className="navbar navbar-dark">
                <div>
                    <form className="form-inline" role="search">
                        <div className="form-group">
                            <input type="text" className="form-control" placeholder="Search" />
                        </div>
                        <button type="submit" className="btn btn-default">提交按钮</button>
                    </form>
                </div>
            </nav>
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

class List extends React.Component {
    render() {
        return (
            <div className="list-group list-group-flush">
                <li className="list-group-item">
                    <div className="card mb-3">
                        <div className="card-body">
                            <h5 className="card-title">Card title</h5>
                            <p className="card-text">This is a wider card with supporting text below as a natural
                                lead-in to additional content. This content is a little bit longer.</p>
                            <p className="card-text">
                                <small className="text-muted">Last updated 3 mins ago</small>
                            </p>
                        </div>
                    </div>
                </li>
                <li className="list-group-item">
                    <div className="card mb-3">
                        <div className="card-header">Header</div>
                        <div className="card-body">
                            <h5 className="card-title">Info card title</h5>
                            <p className="card-text">Some quick example text to build on the card title and make up the
                                bulk of the card's content.</p>
                            <p className="card-text">
                                <small className="text-muted">Last updated 3 mins ago</small>
                            </p>
                        </div>
                    </div>
                </li>
                <li className="list-group-item">Morbi leo risus</li>
                <li className="list-group-item">Porta ac consectetur ac</li>
                <li className="list-group-item">Vestibulum at eros</li>
            </div>
        )
    }
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