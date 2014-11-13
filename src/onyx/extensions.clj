(ns onyx.extensions
  "Extension interfaces for internally used queues, logs,
   and distributed coordination.")

(defmulti apply-log-entry (fn [kw args] kw))

(defmulti replica-diff (fn [kw old new args] kw))

(defmulti fire-side-effects! (fn [kw old new diff args local-state] kw))

(defmulti reactions (fn [kw old new diff args] kw))



(defmulti read-from-inbox (fn []))

(defmulti write-to-outbox (fn []))

(defmulti hold-in-outbox (fn []))

(defmulti flush-outbox (fn []))




(defmulti write-log-entry (fn [log data] (type log)))

(defmulti read-log-entry (fn [log position] (type log)))

(defmulti register-pulse (fn [log id] (type log)))

(defmulti on-delete (fn [log id ch] (type log)))

(defmulti subscribe-to-log (fn [log starting-position ch] (type log)))

(defmulti create-tx-session (fn [queue] (type queue)))

(defmulti create-consumer (fn [queue session queue-name] (type queue)))

(defmulti create-producer (fn [queue session queue-name] (type queue)))

(defmulti consume-message (fn [queue consumer] (type queue)))

(defmulti read-message (fn [queue message] (type queue)))

(defmulti message-uuid (fn [queue message] (type queue)))

(defmulti ack-message (fn [queue message] (type queue)))

(defmulti produce-message (fn ([queue producer session msg] (type queue))
                            ([queue producer session msg group] (type queue))))

(defmulti commit-tx (fn [queue session] (type queue)))

(defmulti rollback-tx (fn [queue session] (type queue)))

(defmulti create-queue (fn [queue task] (type queue)))

(defmulti create-queue-on-session (fn [queue session queue-name] (type queue)))

(defmulti n-messages-remaining (fn [queue session queue-name] (type queue)))

(defmulti n-consumers (fn [queue queue-name] (type queue)))

(defmulti optimize-concurrently (fn [queue event] (type queue)))

(defmulti bootstrap-queue (fn [queue task] (type queue)))

(defmulti close-resource (fn [queue resource] (type queue)))

(defmulti bind-active-session (fn [queue queue-name] (type queue)))

(defmulti producer->queue-name (fn [queue queue-name] (type queue)))

(defmulti create-io-task
  (fn [element parents children]
    (:onyx/type element)))

