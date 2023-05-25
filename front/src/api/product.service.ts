import axios from "axios";

export class ProductService {
  static getProducts() {
    return axios.get("http://localhost:8000/api/product/all");
  }
}
