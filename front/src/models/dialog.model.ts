import { ShortUserModel } from "./user.model";

export class ShortDialog {
  id: string;
  user: ShortUserModel;
  lastMessage: string;

  constructor(source: any) {
    this.id = source.id;
    this.user = source.user;
    this.lastMessage = source.lastMessage;
  }
}
