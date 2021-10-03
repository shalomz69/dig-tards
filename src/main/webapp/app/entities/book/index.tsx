import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Book from './book';
import BookDetail from './book-detail';
import BookUpdate from './book-update';
import BookDeleteDialog from './book-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={BookUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={BookUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={BookDetail} />
      <ErrorBoundaryRoute path={match.url} component={Book} />
    </Switch>
    <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={BookDeleteDialog} />
  </>
);

export default Routes;
