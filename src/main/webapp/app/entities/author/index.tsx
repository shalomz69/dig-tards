import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Author from './author';
import AuthorDetail from './author-detail';
import AuthorUpdate from './author-update';
import AuthorDeleteDialog from './author-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={AuthorUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={AuthorUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={AuthorDetail} />
      <ErrorBoundaryRoute path={match.url} component={Author} />
    </Switch>
    <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={AuthorDeleteDialog} />
  </>
);

export default Routes;
