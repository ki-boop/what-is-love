const isDarkTheme = window.matchMedia("(prefers-color-scheme: dark)").matches;
const defaultTheme = isDarkTheme ? "dark" : "light";

export const useTheme = () => {
  const theme = localStorage.getItem("app-theme") || defaultTheme;

  document.documentElement.setAttribute("data-theme", theme);
  localStorage.setItem("app-theme", theme);

  return theme;
};
