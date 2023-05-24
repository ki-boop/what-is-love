export class ShortUserModel {
  id: string;
  role: string;
  username: string;
  image: string;

  constructor(source: any) {
    this.id = source.id;
    this.role = source.role;
    this.username = source.username;
    this.image = source.image;
  }
}

export class UserModel extends ShortUserModel {}

export const image =