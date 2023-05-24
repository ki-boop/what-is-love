export class ChatItemModel {
  id: string;
  name: string;
  price: number;

  constructor(source: any) {
    this.id = source.id;
    this.name = source.name;
    this.price = source.price;
  }
}
