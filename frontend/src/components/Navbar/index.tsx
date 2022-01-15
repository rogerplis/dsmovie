import React from 'react'
import './styles.css'
import {ReactComponent as  GithubIcon} from  'assets/img/github.svg';

export default function Navbar() {
    return (
        <header>
        <nav className='container'>
          <div className='dsmovie-nav-content'>
            <h1>DSMovie</h1>
            <a href="https://github.com/rogerplis" >
              <div className='dsmovie-contact-container' >
                <GithubIcon/>
                <p className='dsmovie-contact-link'>/rogerplis</p>
              </div>
            </a>
          </div>
        </nav>
      </header>
    )
}
