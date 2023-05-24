import axios from "axios";

export const instance = axios.create({
  headers: {
    "Content-Type": "application/json",
  },
});

const setup = (store: any) => {
  instance.interceptors.request.use(
    (config) => {
      console.log(store.getters.getToken);

      const token = store.getters.getToken;
      if (token) {
        config.headers["Authorization"] = "Bearer " + token; // for Spring Boot back-end
      }
      return config;
    },
    (error) => {
      return Promise.reject(error);
    }
  );

  instance.interceptors.response.use(
    (res) => {
      return res;
    },
    async (err) => {
      const originalConfig = err.config;

      if (originalConfig.url !== "/auth/signin" && err.response) {
        // Access Token was expired
        if (err.response.status === 401 && !originalConfig._retry) {
          originalConfig._retry = true;

          try {
            const rs = await instance.post("/auth/refreshtoken", {
              refreshToken: store.getters.getrefreshToken,
            });

            // const { accessToken } = rs.data;

            // store.dispatch("auth/refreshToken", accessToken);
            // TokenService.updateLocalAccessToken(accessToken);

            // return axiosInstance(originalConfig);
          } catch (_error) {
            return Promise.reject(_error);
          }
        }
      }

      return Promise.reject(err);
    }
  );
};

export default setup;
