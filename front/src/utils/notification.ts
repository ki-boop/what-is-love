import { ToastMessageOptions } from "primevue/toast";
/* eslint-disable */
export type severityType = "success" | "info" | "warn" | "error" | undefined;

export const showCustomNotification = (
  severity: severityType = "success",
  summary?: string,
  detail?: string,
  life: number = 3000
): ToastMessageOptions => {
  return {
    severity: severity,
    summary: summary || "",
    detail: detail || "",
    life: life,
  };
};
