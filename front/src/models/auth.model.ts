export interface ILoginForm {
  login: string;
  password: string;
}

export class AuthStoreModel {
  accessToken: string;
  refreshToken: string;
  user: any;

  constructor(source: any) {
    this.accessToken = source.access_token;
    this.refreshToken = source.refresh_token;
    this.user = source.user;
  }
}
